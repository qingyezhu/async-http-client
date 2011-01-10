/*
 * Copyright 2010 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 */
package com.ning.http.client.consumers;

import com.ning.http.client.BodyConsumer;

import java.io.IOException;
import java.nio.ByteBuffer;

public class StringBufferBodyConsumer implements BodyConsumer {

    private final StringBuffer stringBuffer;
    private final String encoding;

    public StringBufferBodyConsumer(StringBuffer stringBuffer, String encoding) {
        this.stringBuffer = stringBuffer;
        this.encoding = encoding;
    }

    public StringBufferBodyConsumer(StringBuffer stringBuffer) {
        this.stringBuffer = stringBuffer;
        this.encoding = "UTF-8";
    }

    public void consume(ByteBuffer byteBuffer) throws IOException {
        stringBuffer.append(new String(byteBuffer.array(), encoding));
    }

    public void close() throws IOException {
    }
}
