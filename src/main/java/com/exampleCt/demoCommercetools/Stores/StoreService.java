package com.exampleCt.demoCommercetools.Stores;


import com.commercetools.api.models.channel.ChannelResourceIdentifier;
import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.store.Store;
import com.commercetools.api.models.store.StoreDraft;
import com.commercetools.api.models.store_country.StoreCountry;
import org.springframework.stereotype.Service;



@Service
public class StoreService {

    static StoreDataProvider sdp = new StoreDataProvider();
    public static Store createStore(StoreData storeData) {
        StoreDraft storeDraft = StoreDraft
                .builder()
                .name(LocalizedString.ofEnglish(storeData.getName()))
                .key(storeData.getKey())
                .countries(StoreCountry.builder().code(storeData.getCountries()).build())
                .languages(storeData.getLanguages())
                .distributionChannels(ChannelResourceIdentifier.builder().id(storeData.getChannelId()).build())
               // .supplyChannels(ChannelResourceIdentifier.builder().id(storeData.getSupplyChannels()).build())


                .build();
        return sdp.createStore(storeDraft);
    }
}
