/*
 * Created By dogfootmaster@gmail.com on 2022
 * This program is free software
 *
 * @author <a href=“mailto:dogfootmaster@gmail.com“>Jongsang Han</a>
 * @since 2022/02/19
 */

package com.jjong.jpamultidb.db1.repository;

import com.jjong.jpamultidb.db1.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * create on 2022/02/19. create by IntelliJ IDEA.
 *
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author Jongsang Han
 * @version 1.0
 * @see
 * @since 1.0
 */
public interface MemberRepository extends JpaRepository<Member, Long> {

}
