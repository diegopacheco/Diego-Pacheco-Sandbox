package com.github.diegopacheco.redis.module.redissearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Connection;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.commands.ProtocolCommand;
import redis.clients.util.SafeEncoder;

@SuppressWarnings({"rawtypes","unchecked"})
public class RedisSearchModule {
	
	private Jedis jedis;
	
	public RedisSearchModule() {
		jedis = new Jedis("127.0.0.1");
	}
	
	private static enum SearchModuleCommand implements ProtocolCommand {
		
		CREATE("FT.CREATE"),
		SEARCH("FT.SEARCH"),
		ADD("FT.ADD"),
		SUGADD("FT.SUGADD"),
		SUGGET("FT.SUGGET"),
		DROP("FT.DROP");

	    private final byte[] raw;

	    SearchModuleCommand(String alt) {
	      raw = SafeEncoder.encode(alt);
	    }

	    @Override
	    public byte[] getRaw() {
	      return raw;
	    }
	  }
	
	public Map<String,Object> FT_SEARCH(String[] cmdArgs){
		Connection c = jedis.getClient().sendCommand(SearchModuleCommand.SEARCH,cmdArgs);
		List<byte[]> out = c.getBinaryMultiBulkReply();
		
		HashMap<String, Object> result = new HashMap<>();
		for(Object bs : out){
			if ("class java.lang.Long".equals(bs.getClass().toString())){
				result.put("count", new Long(bs.toString()));
			}
			if ("class [B".equals(bs.getClass().toString())){
				result.put("doc", new String((byte[])bs));
			}
			if ("class java.util.ArrayList".equals(bs.getClass().toString())){
				
				List<Object> objs = (List)bs;
				List<String> items = new ArrayList<>();
				for(Object o: objs){
					items.add(new String((byte[])o));
				}
				result.put("items", items);
			}
		}
		return result;
	}
	
	public List<String> FT_SUGGET(String[] cmdArgs){
		Connection c = jedis.getClient().sendCommand(SearchModuleCommand.SUGGET,cmdArgs);
		List<String> out = c.getMultiBulkReply();
		return out;
	}
	
	public String FT_CREATE(String[] cmdArgs){
		Connection c = jedis.getClient().sendCommand(SearchModuleCommand.CREATE,cmdArgs);
		String out = c.getBulkReply();
		return out;
	}
	
	public String FT_ADD(String[] cmdArgs){
		Connection c = jedis.getClient().sendCommand(SearchModuleCommand.ADD,cmdArgs);
		String out = c.getBulkReply();
		return out;
	}
	
	public Long FT_SUGADD(String[] cmdArgs){
		Connection c = jedis.getClient().sendCommand(SearchModuleCommand.SUGADD,cmdArgs);
		Long out = c.getIntegerReply();
		return out;
	}
	
	public String FT_DROP(String[] cmdArgs){
		Connection c = jedis.getClient().sendCommand(SearchModuleCommand.DROP,cmdArgs);
		String out = c.getBulkReply();
		return out;
	}
	
}
