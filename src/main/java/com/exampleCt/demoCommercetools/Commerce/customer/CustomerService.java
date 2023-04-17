package com.exampleCt.demoCommercetools.Commerce.customer;

import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.customer.*;
import com.commercetools.api.models.type.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class CustomerService {

    CustomerDataProvider cdp = new CustomerDataProvider();

    public  Customer createCustomer(CustomerData customerData) {
        CustomerDraft customerDraft = CustomerDraft
                .builder()
                .email(customerData.getEmail())
                .password(customerData.getPassword())
                .firstName(customerData.getFirstname())
                .lastName(customerData.getLastname())
                .companyName(customerData.getCompany())
                .customerNumber(customerData.getCustomernumber())
                .externalId(customerData.getExternalId())

                .custom(customFieldsDraftBuilder -> customFieldsDraftBuilder
                        .type(typeResourceIdentifierBuilder -> typeResourceIdentifierBuilder
                                .key(customerData.getTypeKey()))
                        .fields(fieldContainerBuilder -> fieldContainerBuilder
                                .addValue(customerData.getFieldName(),customerData.getValues())))
                .build();
        return cdp.createCustomer(customerDraft);
    }

    public Type createCustomType(CustomerData customerData) {

        // Create the FieldDefinition
        FieldDefinition fieldDefinition = FieldDefinition
                .builder()
                .type(FieldType.localizedStringBuilder().build())
                .name(customerData.getFieldName())

                .inputHint(TypeTextInputHint.SINGLE_LINE)

                .label(
                        LocalizedString.builder().addValue("en",customerData.getFieldLabel()).build())
                .required(false)
                .build();

// Create typeDraft with the FieldDefinition
        final TypeDraft typeDraft = TypeDraft
                .builder()
                .key(customerData.getTypeKey())
                .name(
                        LocalizedString
                                .builder()
                                .addValue("en", customerData.getTypeName())
                                .build()
                )
                .resourceTypeIds(List.of(ResourceTypeId.CUSTOMER))
                .fieldDefinitions(List.of(fieldDefinition))
                .build();
        return cdp.createCustomType(typeDraft);

    }

    public CustomerToken generateToken(CustomerData customerData) {
        CustomerCreatePasswordResetToken createPasswordResetToken = CustomerCreatePasswordResetToken
                .builder()
                .email(customerData.getEmail())
                .build();
        return cdp.generateToken(createPasswordResetToken);
    }

    public Customer resetPasswordToken(CustomerData customerData) {
        CustomerResetPassword customerResetPassword = CustomerResetPassword
                .builder().tokenValue(customerData.getValue())
                .newPassword(customerData.getNewpassword())
                .build();
        return  cdp.resetPasswordToken(customerResetPassword);
    }

    public Customer changepassword(CustomerData customerData) {

        CustomerChangePassword customerChangePassword= CustomerChangePassword
                .builder()
                .id(customerData.getId())
                .version(customerData.getVersion())
                .currentPassword(customerData.getCurrentPassword())
                .newPassword(customerData.getNewpassword())
                .build();

        return  cdp.changepassword(customerChangePassword);
    }

    public CustomerSignInResult login(CustomerData customerData) {
        log.info("this is service");


        CustomerSignin customerSignin = CustomerSignin
                .builder()
                .email(customerData.getEmail())
                .password(customerData.getPassword())
                .build();
        return cdp.login(customerSignin);
    }
}
