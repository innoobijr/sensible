package com.innocentobi.sensible.instance.envs

import com.innocentobi.sensible.instance.modules.GoogleLocationModules
import com.innocentobi.sensible.syntax.Environment


object ProdEnvironment : Environment {

    val locationService = GoogleLocationModules.FusedLocationModule


}