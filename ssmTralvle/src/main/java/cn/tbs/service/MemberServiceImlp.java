package cn.tbs.service;

import cn.tbs.mapper.MemberMapper;
import cn.tbs.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberServiceImlp implements MemeberService{
    @Autowired
    MemberMapper memberMapper;
    @Override
    public List<Member> findAll() {
        return memberMapper.findAll();
    }
}
