package be.ros.spring_panier_exo.services;

import java.util.List;

public interface BaseService<TDTO, TFORM, TID> {
    List<TDTO> getAll();
    TDTO getOneById(TID id);
    TDTO save(TFORM tform);
    TDTO update(TFORM tform, TID id);
    TID delete(TID id);
}
