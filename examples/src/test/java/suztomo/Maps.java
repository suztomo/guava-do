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
import com.google.common.collect.Multimaps;
import com.google.common.truth.Truth;
import org.junit.Test;

public class Maps {

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
}
