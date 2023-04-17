package com.exampleCt.demoCommercetools.Commerce.Channels;


import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.channel.Channel;
import com.commercetools.api.models.channel.ChannelPagedQueryResponse;
import io.vrap.rmf.base.client.ApiHttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/channel")
@Slf4j
public class ChannelController {

    @Autowired
    ChannelService channelService;


    @Autowired
    ProjectApiRoot projectApiRoot;

    @PostMapping
    public Channel createChannel(@RequestBody ChannelData channelData)
    {
        return channelService.createChannel(channelData);
    }

    @GetMapping
    public ChannelPagedQueryResponse getAllChannel()
    {
        return projectApiRoot.channels().get().executeBlocking().getBody();
    }

    @PostMapping("/{id}")
    public Channel getChannelById(@PathVariable String id)
    {
        return projectApiRoot.channels().withId(id).get().executeBlocking().getBody();
    }

    @DeleteMapping("/{id}")
    public ApiHttpResponse deleteChannelById(@PathVariable String id)
    {
        return projectApiRoot.channels().withId(id).delete().addVersion(2).executeBlocking();
    }

}
