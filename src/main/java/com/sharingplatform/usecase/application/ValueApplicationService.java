package com.benz.usecase.application;

import com.benz.framework.AssertionConcern;
import com.benz.usecase.domain.ContributionBU;
import com.benz.usecase.domain.Value;
import com.benz.usecase.domain.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hongying.fu on 2/10/2017.
 */
@Service
public class ValueApplicationService {

    @Autowired
    private ValueRepository valueRepository;

    public Long createValue(ValueCreateCommand aCommand) {
       Value value = new Value(aCommand.getText());
       return value.create() ;
    }

    public void updateValue(ValueCommand command) {
        Value value = existingValue(command.getId());
        value.update(command.getText());
    }

    public void deleteValue(Long id) {
        Value value = existingValue(id);
        value.delete();
    }

    private Value existingValue(Long id) {
        Value value = valueRepository.findOne(id);
        AssertionConcern.assertArgumentNotNull(value, "Business value does not exist");
        return value;
    }
}
