package com.exampleCt.demoCommercetools.Commerce.Channels;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.channel.Channel;
import com.commercetools.api.models.channel.ChannelDraft;
import com.exampleCt.demoCommercetools.Client;

public class ChannelDataProvider {

    ProjectApiRoot apiRoot = new Client().createApiClient();

    public Channel createChannel(ChannelDraft draft)
    {
        return apiRoot.channels().post(draft).executeBlocking().getBody();
    }

}
