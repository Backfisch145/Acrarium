/*
 * (C) Copyright 2020-2024 Lukas Morawietz (https://github.com/F43nd1r)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.faendir.acra.ui.view.error

import com.faendir.acra.i18n.Messages
import com.faendir.acra.navigation.View
import com.faendir.acra.ui.ext.*
import com.faendir.acra.ui.view.Overview
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.FlexLayout
import com.vaadin.flow.router.*
import com.vaadin.flow.server.auth.AnonymousAllowed

@Suppress("LeakingThis")
@View
@AnonymousAllowed
class ErrorView : FlexLayout(), HasErrorParameter<NotFoundException> {
    init {
        setSizeFull()
        flexDirection = FlexDirection.COLUMN
        alignItems = FlexComponent.Alignment.CENTER
        justifyContentMode = FlexComponent.JustifyContentMode.CENTER
        paragraph("404") {
            style["font-size"] = "200px"
            style["line-height"] = "80%"
            setMargin(0, SizeUnit.PIXEL)
        }
        translatableParagraph(Messages.URL_NOT_FOUND)
        add(RouterLink("", Overview::class.java).apply {
            translatableButton(Messages.GO_HOME)
        })
    }

    override fun setErrorParameter(event: BeforeEnterEvent?, parameter: ErrorParameter<NotFoundException>): Int = 404
}