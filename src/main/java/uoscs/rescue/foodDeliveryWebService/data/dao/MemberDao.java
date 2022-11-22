package uoscs.rescue.foodDeliveryWebService.data.dao;

import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Member;

import java.util.List;

public interface MemberDao {

    MemberDto save(MemberDto memberDto);

    MemberDto findById(String id);
    Member findMemberEntityById(String id);
    List<MemberDto> getAllMemberList();

    void updateById(String id, MemberDto updateDto);

    void deleteById(String id);
}
