package suztomo;

import com.google.common.truth.Truth;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import org.junit.Test;

public class ListTest {

  @Test
  public void sortByPortion() {
    Comparator<String> comparator = Comparator.comparing(String::length)
        .thenComparing(Function.identity());

    List<String> list = Arrays.asList("abc", "d", "a", "ab");
    Collections.sort(list, comparator);
    Truth.assertThat(list).isEqualTo(Arrays.asList("a", "d", "ab", "abc"));
  }

}
