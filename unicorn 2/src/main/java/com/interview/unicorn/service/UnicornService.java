package com.interview.unicorn.service;

import com.interview.unicorn.dao.UnicornDAO;
import com.interview.unicorn.domain.UnicornDetails;
import com.interview.unicorn.exception.InvalidUnicornException;
import com.interview.unicorn.exception.UnicornNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnicornService {

    private final UnicornDAO unicornDAO;

    public UnicornService(UnicornDAO unicornDAO) {
        this.unicornDAO = unicornDAO;
    }

    public UnicornDetails getUnicornById(Integer id) {
        return unicornDAO.findById(id).orElseThrow(() -> new UnicornNotFoundException(id));
    }

    public List<UnicornDetails> getAllUnicorns() {
        List<UnicornDetails> allUnicorns = unicornDAO.findAll();
        if(allUnicorns.isEmpty()){
            throw new UnicornNotFoundException();
        }
        return allUnicorns;
    }

    public Integer saveUnicornDetails(UnicornDetails unicornDetails) {
        if(unicornDetails == null || unicornDetails.getName()==null){
            throw new InvalidUnicornException("Invalid unicorn details");
        }
        UnicornDetails details = unicornDAO.save(unicornDetails);
        return details.getUnicornId();
    }

    public void updateUnicornDetails(Integer unicornId, UnicornDetails unicornDetails) {
        UnicornDetails existingUnicornDetails = unicornDAO.findById(unicornId).orElseThrow(() -> new UnicornNotFoundException(unicornId));
        saveUnicornDetails(unicornDetails);
    }
}
