import java.util.ArrayList;
import java.util.List;

public class LRUCache {
  private List<Integer> index;
  private List<Integer> cache;
  private int capacity;

  public LRUCache(int capacity) {
    index = new ArrayList<>();
    cache = new ArrayList<>();
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!index.contains(key)) {
      return -1;
    }

    int idx = index.indexOf(key);
    int res = cache.get(idx);

    // Remove from Old Cache
    cache.remove(idx);
    index.remove(idx);

    // Add to new Cache
    cache.add(res);
    index.add(key);

    return res;
  }

  public void put(int key, int value) {
    if (index.contains(key)) {
      int idx = index.indexOf(key);
      cache.remove(idx);
      index.remove(idx);
    }

    if (capacity == index.size()) {
      cache.remove(0);
      index.remove(0);
    }

    cache.add(value);
    index.add(key);
  }
}
