package com.maxor.turopizza.data

/** This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 * Copyright 2020, Gerardo Marquez.
 */

data class TuroBusinessData (
    val rating : Double = 0.0,
    val id : String,
    val name : String,
    val image_url : String,
    val distance : Double = 0.0)