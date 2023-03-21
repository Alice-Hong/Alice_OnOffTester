package com.wonderland.alice.onofftester.ui

import android.app.admin.DevicePolicyManager
import android.content.*
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.NumberPicker
import android.widget.NumberPicker.OnValueChangeListener
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.wonderland.alice.onofftester.R
import com.wonderland.alice.onofftester.SCREEN_ON_TIMER
import com.wonderland.alice.onofftester.TAG
import com.wonderland.alice.onofftester.UserPreferencesRepository
import com.wonderland.alice.onofftester.alarm.ACT_SCREEN
import com.wonderland.alice.onofftester.alarm.AlarmUtils
import com.wonderland.alice.onofftester.databinding.ActivityMainBinding
import com.wonderland.alice.onofftester.receiver.AppDeviceAdminReceiver


class MainActivity : AppCompatActivity() {

    companion object {
        var rootScreenOnAtAlarm = false
    }

    private var _bindging: ActivityMainBinding? = null
    private val bindging get() = _bindging!!

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private val alarmUtils by lazy { AlarmUtils(this) }

    private var countDownTimer: CountDownTimer? = null

    private val deviceAdminResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            when (result.resultCode) {
                RESULT_CANCELED -> Toast.makeText(
                    this,
                    R.string.admin_cancelled,
                    Toast.LENGTH_SHORT
                ).show()
                RESULT_OK -> Toast.makeText(
                    this,
                    R.string.admin_activated,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _bindging = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindging.root)
        bindging.lifecycleOwner = this
        bindging.viewModel = viewModel

        initializeUI()
        initializeClickListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        try {
            unregisterReceiver(screenOnReceiver)
        } catch (_: IllegalArgumentException) {
        } catch (_: Exception) {
        }

    }

    // 화면 켜짐꺼짐 감시자
    private var screenOnReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (intent.action == Intent.ACTION_SCREEN_ON) {
                Log.d(TAG, "화면 켜짐")
                if (rootScreenOnAtAlarm) {
                    showTimer(UserPreferencesRepository.screenOnTimer)
                } else {
                    if(viewModel.moreThanOnceScreenOffEvent) {
                        Log.d(TAG, "테스트 중단")
                        testStop()
                    }else{
                        Log.d(TAG, "처음 이벤트 무시")
                    }
                }
            } else if (intent.action == Intent.ACTION_SCREEN_OFF) {
                Log.d(TAG, "화면 꺼짐")
                viewModel.moreThanOnceScreenOffEvent = true
                rootScreenOnAtAlarm = false
            }
        }
    }
    private val screenOnOffFilter = IntentFilter().apply {
        addAction(Intent.ACTION_SCREEN_OFF)
        addAction(Intent.ACTION_SCREEN_ON)
    }

    private fun initializeUI() {

        bindging.onNumPicker.apply {
            minValue = 1
            maxValue = 999
            wrapSelectorWheel = false
            descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
            value = UserPreferencesRepository.screenOnTimer
        }
        bindging.offNumPicker.apply {
            minValue = 1
            maxValue = 999
            wrapSelectorWheel = false
            descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
            value = UserPreferencesRepository.screenOffTimer
        }

    }

    private fun initializeClickListener() {

        bindging.onNumPicker.setOnValueChangedListener { _, oldVal, newVal ->
            Log.d(TAG, "onNumPicker:$oldVal / $newVal")
            UserPreferencesRepository.screenOnTimer = newVal
        }

        bindging.offNumPicker.setOnValueChangedListener { _, oldVal, newVal ->
            Log.d(TAG, "offNumPicker:$oldVal / $newVal")
            UserPreferencesRepository.screenOffTimer = newVal
        }

        bindging.btnOnoff.setOnClickListener {
            when (viewModel.onTesting.value) {
                true -> testStop()
                else -> testStart()
            }
        }

        bindging.btnDeviceadmin.setOnClickListener {
            activateAdmin()
        }

        bindging.btnScreenoff.setOnClickListener {
            screenOffAction()
        }

        val frontQualitiesMap=mapOf<Button, Int>(
            bindging.btnOnAdd10 to 10,
            bindging.btnOnAdd100 to 100,
            bindging.btnOnRemove10 to -10,
            bindging.btnOnRemove100 to -100,
            bindging.btnOffAdd10 to 10,
            bindging.btnOffAdd100 to 100,
            bindging.btnOffRemove10 to -10,
            bindging.btnOffRemove100 to -100
        )
        for ((key, value) in frontQualitiesMap) {
            key.setOnClickListener {
                when(key.id){
                    bindging.btnOnAdd10.id,
                    bindging.btnOnAdd100.id,
                    bindging.btnOnRemove10.id,
                    bindging.btnOnRemove100.id->{
                        val t = bindging.onNumPicker.value + Integer.parseInt(key.tag.toString())
                        val onTime = checkMaxNum(t)
                        bindging.onNumPicker.value = onTime
                        UserPreferencesRepository.screenOnTimer = onTime
                    }
                    bindging.btnOffAdd10.id,
                    bindging.btnOffAdd100.id,
                    bindging.btnOffRemove10.id,
                    bindging.btnOffRemove100.id->{
                        val t = bindging.offNumPicker.value + Integer.parseInt(key.tag.toString())
                        val offTime = checkMaxNum(t)
                        bindging.offNumPicker.value = offTime
                        UserPreferencesRepository.screenOffTimer = offTime
                    }

                }
            }
        }
    }

    private fun checkMaxNum(i:Int): Int{
        return if(i > 999) {
            999
        }else if(i < 1){
            1
        } else {
            i
        }
    }

    private fun testStart() {
        Log.d(TAG, "Start Testing")
        viewModel.changeOnTesting(true)
        alarmUtils.setAlarm(ACT_SCREEN.SCREEN_ON)
        registerReceiver(screenOnReceiver, screenOnOffFilter)
        showTimer(UserPreferencesRepository.screenOnTimer)
    }

    private fun testStop() {
        Log.d(TAG, "Stop Testing")
        try {
            unregisterReceiver(screenOnReceiver)
        } catch (_: IllegalArgumentException) {
        } catch (_: Exception) {
        }
        viewModel.changeOnTesting(false)
        alarmUtils.cancelAlarm()
        showTimer()
    }

    private fun activateAdmin() {
        val deviceAdmin = ComponentName(this, AppDeviceAdminReceiver::class.java)
        val intent = Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN)
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, deviceAdmin)
        deviceAdminResult.launch(intent)
    }

    private fun screenOffAction() {
        try {
            val dpm =
                getSystemService(AppCompatActivity.DEVICE_POLICY_SERVICE) as DevicePolicyManager
            dpm.lockNow()
        } catch (e: Exception) {
            Log.e(TAG, "ScreenOff Error: ${e.message}")
        }
    }

    private fun showTimer(count: Int = 0) {
        if (count > 0) {
            Log.d(TAG, "showTimer: $count")
            val timerDuration: Long = (count * 60 * 1000).toLong()
            countDownTimer = object : CountDownTimer(timerDuration, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    val remainingTimeInSeconds = millisUntilFinished / 1000
                    val minutes = remainingTimeInSeconds / 60
                    val seconds = remainingTimeInSeconds % 60
                    bindging.tvDisplayTime.text = String.format("%02d:%02d", minutes, seconds)
                }

                override fun onFinish() {
                    bindging.tvDisplayTime.text = "00:00"
                }
            }
            countDownTimer?.start()
        } else {
            countDownTimer?.cancel()
            bindging.tvDisplayTime.text = "00:00"
        }
    }

}