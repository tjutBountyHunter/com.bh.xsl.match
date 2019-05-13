package xsl.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 说明：JedisPool 代理
 *
 * @Auther: 11432_000
 * @Date: 2019/5/12 21:02
 * @Description:
 */
public class MyJedisPool extends JedisPool{

	private JedisPool jedisPool;

	public MyJedisPool(String host,int port,int timeout,Integer database,JedisPoolConfig jedisPoolConfig){
		this.jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, null,database);
	}

	public MyJedisPool(String host,int port,int timeout,Integer database) {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(100);
		jedisPoolConfig.setMaxWaitMillis(10000);
		jedisPoolConfig.setMaxTotal(1000);
		jedisPoolConfig.setMinIdle(50);
		jedisPoolConfig.setTestOnBorrow(true);
		jedisPoolConfig.setTestOnReturn(true);
		jedisPoolConfig.setTestWhileIdle(true);
		jedisPoolConfig.setNumTestsPerEvictionRun(50);
		this.jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, null,database);
	}

	@Override
	public Jedis getResource() {
		return this.jedisPool.getResource();
	}
}
