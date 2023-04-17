package com.exampleCt.demoCommercetools.Commerce.Channels;
import com.commercetools.api.models.channel.Channel;
import com.commercetools.api.models.channel.ChannelDraft;
import com.commercetools.api.models.channel.ChannelRoleEnum;
import com.commercetools.api.models.common.LocalizedString;
import org.springframework.stereotype.Service;

@Service
public class ChannelService {

    static ChannelDataProvider cdpp = new   ChannelDataProvider();
    public static Channel createChannel(ChannelData channelData) {
        ChannelDraft draft = ChannelDraft
                .builder()
                .name(LocalizedString.ofEnglish(channelData.getName()))
                .key(channelData.getKey())
                .description(LocalizedString.ofEnglish(channelData.getDescription()))
                .roles(ChannelRoleEnum.findEnum(channelData.getRoles()))
                .build();

        return cdpp.createChannel(draft);
    }
}
