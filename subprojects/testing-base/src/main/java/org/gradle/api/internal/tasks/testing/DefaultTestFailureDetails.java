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

package org.gradle.api.internal.tasks.testing;

import org.gradle.api.tasks.testing.TestFailureDetails;

public class DefaultTestFailureDetails implements TestFailureDetails {

    private final String message;
    private final String className;
    private final String stacktrace;
    private final boolean isAssertionFailure;

    public DefaultTestFailureDetails(String message, String className, String stacktrace, boolean isAssertionFailure) {
        this.message = message;
        this.className = className;
        this.stacktrace = stacktrace;
        this.isAssertionFailure = isAssertionFailure;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public String getStacktrace() {
        return stacktrace;
    }

    @Override
    public boolean isAssertionFailure() {
        return isAssertionFailure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DefaultTestFailureDetails that = (DefaultTestFailureDetails) o;

        if (isAssertionFailure != that.isAssertionFailure) {
            return false;
        }
        if (message != null ? !message.equals(that.message) : that.message != null) {
            return false;
        }
        if (className != null ? !className.equals(that.className) : that.className != null) {
            return false;
        }
        return stacktrace != null ? stacktrace.equals(that.stacktrace) : that.stacktrace == null;
    }

    @Override
    public int hashCode() {
        int result = message != null ? message.hashCode() : 0;
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + (stacktrace != null ? stacktrace.hashCode() : 0);
        result = 31 * result + (isAssertionFailure ? 1 : 0);
        return result;
    }
}
