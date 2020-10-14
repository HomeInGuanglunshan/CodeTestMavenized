package write.from.memory.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class Ehcache {
	
	public static void main(String[] args) {
		CacheManager cm = CacheManager.create("./src/write/from/memory/ehcache/a.xml");
		Cache c = cm.getCache("HelloWorldCache");
//		CacheManager cm = CacheManager.create("./src/write/from/memory/ehcache/ehcache.xml");
//		Cache c = cm.getCache("mvc");
		Element se = new Element("key", "value");
		c.put(se);
		Element e = c.get("key");
		System.out.println(e.getObjectValue());
		c.flush();
		cm.shutdown();
	}
}
