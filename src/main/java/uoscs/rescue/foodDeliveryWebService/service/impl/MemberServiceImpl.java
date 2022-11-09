package uoscs.rescue.foodDeliveryWebService.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uoscs.rescue.foodDeliveryWebService.data.dao.MemberDao;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Member;
import uoscs.rescue.foodDeliveryWebService.exception.NoSuchMemberException;
import uoscs.rescue.foodDeliveryWebService.service.MemberService;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    @Autowired
    private final MemberDao memberDao;

    @Override
    public MemberDto save(MemberDto memberDto) {
        return memberDao.save(memberDto);
    }

    @Override
    public boolean checkIdAndPassword(String id, String password) {
        MemberDto memberDto;

        try{
            memberDto = memberDao.findById(id);
        }catch (NoSuchMemberException ex){  //매칭되는 아이디가 없는 경우
            return false;
        }

        if(!memberDto.getPassword().equals(password))   //비번이 맞지 않는 경우
            return false;

        return true;
    }
}
