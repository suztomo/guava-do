/*
 *
 *  * Copyright 2019 Google LLC.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 *
 */

package suztomo;

import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.truth.Truth;
import java.util.Collection;
import java.util.Map.Entry;
import org.junit.Test;

public class MapTest {

  @Test
  public void filterValues() {
    ImmutableListMultimap.Builder<String, Integer> builder = ImmutableListMultimap.builder();
    builder.putAll("even", 2, 4, 6, 8, 10);
    builder.putAll("odd", 1, 3, 5, 7, 9);
    ImmutableListMultimap<String, Integer> multimap = builder.build();

    ImmutableListMultimap<String, Integer> filteredMultimap = ImmutableListMultimap
        .copyOf(Multimaps.filterValues(multimap, value -> value < 5));
    Truth.assertThat(filteredMultimap.values()).hasSize(4);
  }

  @Test
  public void transformValues() {
    ImmutableSetMultimap<String, Integer> map = ImmutableSetMultimap.of(
        "tomo", 3,
        "tomo", 9,
        "joe", 5,
        "kei", 2
    );

    Truth.assertThat(map).hasSize(4);
    Truth.assertThat(map.asMap()).hasSize(3);

    Multimap<String, Integer> transformed =
        ImmutableMultimap.copyOf(Multimaps.transformValues(map, i -> i * i));
    Truth.assertThat(transformed.get("tomo")).containsExactly(9, 81);
  }

  @Test
  public void indexByPropertyOfMultimapValue() {
    ImmutableSetMultimap<String, Integer> map = ImmutableSetMultimap.of(
        "tomo", 3,
        "tomo", 9,
        "joe", 5,
        "kei", 3
    );

    ImmutableMap<Integer, Collection<Entry<String, Integer>>> indexedMap = Multimaps
        .index(map.entries(), Entry::getValue).asMap();

    ImmutableMap<Integer, ImmutableSetMultimap<String, Integer>> result = ImmutableMap
        .copyOf(
            Maps.transformValues(indexedMap,
                entries -> ImmutableSetMultimap.copyOf(entries)));

    Truth.assertThat(result).hasSize(3);
    Truth.assertThat(result.get(3).keySet()).containsExactly("tomo", "kei"); // tomo and kei

    Truth.assertThat(result.get(3).get("tomo")).containsExactly(3); // tomo and kei
  }
}
