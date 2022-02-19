/*
 * Created By dogfootmaster@gmail.com on 2022
 * This program is free software
 *
 * @author <a href=“mailto:dogfootmaster@gmail.com“>Jongsang Han</a>
 * @since 2022/02/19
 */

package com.jjong.jpamultidb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

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
@Configuration
public class ChainTxConfig {

  @Bean
  @Primary
  public PlatformTransactionManager transactionManager(PlatformTransactionManager transactionManager1,
      PlatformTransactionManager transactionManager2) {
    return new ChainedTransactionManager(transactionManager1, transactionManager2);
  }

}
