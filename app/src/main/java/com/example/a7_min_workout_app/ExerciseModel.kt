package com.example.a7_min_workout_app

import android.widget.TextView

data class ExerciseModel(var id:Int,var name: String,var img:Int,var isfinished:Boolean,var isstarted:Boolean)
class Exercise{
    companion object{
        fun funexerciselist():ArrayList<ExerciseModel>? {
            val exerciselist = ArrayList<ExerciseModel>()

//            val E0 = ExerciseModel(0, "side plank", R.drawable.ic_side_plank_1, false, false)
//            exerciselist.add(E0)
            val E1 = ExerciseModel(1, "squat", R.drawable.ic_squat_2, false, false)
            exerciselist.add(E1)
            val E2= ExerciseModel(2, "step up onto chair", R.drawable.ic_step_up_onto_chair_3, false, false)
            exerciselist.add(E2)
            val E3 = ExerciseModel(3, "triceps dip on chair", R.drawable.ic_triceps_dip_on_chair_4, false, false)
            exerciselist.add(E3)
            val E4 = ExerciseModel(4, "abdominal crunch", R.drawable.ic_abdominal_crunch_5, false, false)
            exerciselist.add(E4)
            val E5 = ExerciseModel(5, "push up and rotation", R.drawable.ic_push_up_and_rotation_6, false, false)
            exerciselist.add(E5)
            val E6 = ExerciseModel(6, "lunge", R.drawable.ic_lunge_7, false, false)
            exerciselist.add(E6)
            val E7 = ExerciseModel(7, "plank", R.drawable.ic_plank_8, false, false)
            exerciselist.add(E7)
            val E8 = ExerciseModel(8, "push up", R.drawable.ic_push_up_9, false, false)
            exerciselist.add(E8)
            val E9 = ExerciseModel(9, "jumping jacks", R.drawable.ic_jumping_jacks_10, false, false)
            exerciselist.add(E9)
            val E10 = ExerciseModel(10, " ", R.drawable.ic_jumping_jacks_10, false, false)
            exerciselist.add(E10)

            return exerciselist
        }
    }
}