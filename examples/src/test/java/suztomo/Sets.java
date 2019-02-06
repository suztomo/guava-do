package suztomo;

import static com.google.common.collect.ImmutableSet.toImmutableSet;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.truth.Truth;
import java.util.Collection;
import org.junit.Test;

public class Sets {


  @Test
  public void mergeSets() {
    ImmutableList<ImmutableSet<String>> input = ImmutableList.of(
        ImmutableSet.of("hello", "world"),
        ImmutableSet.of("good", "evening")
    );

    ImmutableSet<String> mergedSet = input.stream().flatMap(Collection::stream)
        .collect(toImmutableSet());
    Truth.assertThat(mergedSet).contains("evening");
  }
}
