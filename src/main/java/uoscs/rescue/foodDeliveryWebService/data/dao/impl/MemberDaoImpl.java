package uoscs.rescue.foodDeliveryWebService.data.dao.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uoscs.rescue.foodDeliveryWebService.data.dao.MemberDao;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Member;
import uoscs.rescue.foodDeliveryWebService.data.mapper.MemberMapper;
import uoscs.rescue.foodDeliveryWebService.data.repository.MemberRepository;

import javax.persistence.EntityManager;

@Slf4j
@Repository //transactional 적용됨
@AllArgsConstructor
public class MemberDaoImpl implements MemberDao {
    @Autowired
    final private MemberRepository repository;
    @Autowired
    final private MemberMapper memberMapper;

    //@Autowired final private EntityManager entityManager;

    @Override
    public MemberDto save(MemberDto memberDto) {
        Member member = memberMapper.dtoToMember(memberDto);
        Member savedMember = repository.save(member);
        log.info("member saved {}", savedMember);

        return memberMapper.memberToDto(savedMember);
    }
}
