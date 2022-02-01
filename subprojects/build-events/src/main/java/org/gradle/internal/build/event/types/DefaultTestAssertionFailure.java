/*
 * Copyright 2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.internal.build.event.types;

import org.gradle.tooling.internal.protocol.InternalFailure;
import org.gradle.tooling.internal.protocol.InternalTestAssertionFailure;

public class DefaultTestAssertionFailure extends AbstractTestFailure implements InternalTestAssertionFailure {

    private DefaultTestAssertionFailure(String message, String description, InternalFailure cause, String className, String stacktrace) {
        super(message, description, cause, className, stacktrace);
    }

    public static DefaultTestAssertionFailure create(Throwable t, String message, String className, String stacktrace) {
        Throwable cause = t.getCause();
        InternalFailure causeFailure = cause != null && cause != t ? DefaultFailure.fromThrowable(cause) : null;
        return new DefaultTestAssertionFailure(message, stacktrace, causeFailure, className, stacktrace);
    }
}
