package be.ros.spring_panier_exo.mappers;

public interface BaseMapper<TDTO, TFORM, TENTITY> {
    
    TDTO entityToDto(TENTITY entity);

    TENTITY dtoToEntity(TDTO dto);

    TENTITY formToEntity(TFORM form);

}
