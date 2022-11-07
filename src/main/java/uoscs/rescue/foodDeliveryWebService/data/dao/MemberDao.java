package uoscs.rescue.foodDeliveryWebService.data.dao;

import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;

public interface MemberDao {

    MemberDto save(MemberDto memberDto);

    MemberDto findById(String id);

    void updateById(String id, MemberDto updateDto);

    void deleteById(String id);
}
