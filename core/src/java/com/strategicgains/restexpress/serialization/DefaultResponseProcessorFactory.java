/*
    Copyright 2013, Strategic Gains, Inc.

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

		http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/
package com.strategicgains.restexpress.serialization;

import com.strategicgains.restexpress.response.RawResponseWrapper;
import com.strategicgains.restexpress.response.ResponseProcessor;
import com.strategicgains.restexpress.response.ResponseProcessorFactory;
import com.strategicgains.restexpress.response.ResponseWrapper;
import com.strategicgains.restexpress.serialization.json.JacksonJsonProcessor;
import com.strategicgains.restexpress.serialization.text.DefaultTxtProcessor;
import com.strategicgains.restexpress.serialization.xml.XstreamXmlProcessor;

/**
 * @author toddf
 * @since Jul 17, 2013
 */
public class DefaultResponseProcessorFactory
implements ResponseProcessorFactory
{
	@Override
	public ResponseProcessor newJsonProcessor()
	{
		return newJsonProcessor(new RawResponseWrapper());
	}

	@Override
	public ResponseProcessor newJsonProcessor(ResponseWrapper wrapper)
	{
		return new ResponseProcessor(new JacksonJsonProcessor(), wrapper);
	}

	@Override
	public ResponseProcessor newXmlProcessor()
	{
		return newXmlProcessor(new RawResponseWrapper());
	}

	@Override
	public ResponseProcessor newXmlProcessor(ResponseWrapper wrapper)
	{
		return new ResponseProcessor(new XstreamXmlProcessor(), wrapper);
	}

	@Override
    public ResponseProcessor newTxtProcessor()
    {
		return newTxtProcessor(new RawResponseWrapper());
    }

	@Override
    public ResponseProcessor newTxtProcessor(ResponseWrapper wrapper)
    {
		return new ResponseProcessor(new DefaultTxtProcessor(), wrapper);
    }
}