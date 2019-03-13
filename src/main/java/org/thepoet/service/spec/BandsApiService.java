package org.thepoet.service.spec;

import org.thepoet.model.Band;

import java.util.List;

/**
 * @author Oguzhan Dogan <dogan_oguzhan@hotmail.com>
 */
public interface BandsApiService {
    List<Band> getListFromApi();
}
