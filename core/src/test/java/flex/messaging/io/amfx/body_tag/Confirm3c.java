/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package flex.messaging.io.amfx.body_tag;

import flex.messaging.io.amfx.DeserializationConfirmation;
import flex.messaging.io.amf.ActionMessage;
import flex.messaging.io.amf.MessageBody;
import flex.messaging.io.amf.ASObject;
import flex.messaging.MessageException;

public class Confirm3c extends DeserializationConfirmation {
    private ActionMessage EXPECTED_VALUE;

    public Confirm3c() {
    }

    public ActionMessage getExpectedMessage() {
        if (EXPECTED_VALUE == null) {
            ActionMessage m = new ActionMessage();

            MessageBody body = new MessageBody();
            body.setData("Sample Value");
            m.addBody(body);

            body = new MessageBody();
            ASObject aso = new ASObject();
            aso.put("prop0", new Double(Double.NEGATIVE_INFINITY));
            aso.put("prop1", new Double(Double.POSITIVE_INFINITY));
            body.setData(aso);
            m.addBody(body);

            body = new MessageBody();
            Object list = createList(2);
            addToList(list, 0, Boolean.FALSE);
            addToList(list, 1, Boolean.TRUE);
            body.setData(list);
            m.addBody(body);

            EXPECTED_VALUE = m;
        }
        return EXPECTED_VALUE;
    }

    public MessageException getExpectedException() {
        return null;
    }
}
