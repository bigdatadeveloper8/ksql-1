/*
 * Copyright 2018 Confluent Inc.
 *
 * Licensed under the Confluent Community License (the "License"); you may not use
 * this file except in compliance with the License.  You may obtain a copy of the
 * License at
 *
 * http://www.confluent.io/confluent-community-license
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */

package io.confluent.ksql.parser.tree;

import static com.google.common.base.MoreObjects.toStringHelper;
import static java.util.Objects.requireNonNull;

import java.util.Objects;
import java.util.Optional;

public class ExplainFormat
    extends ExplainOption {

  public enum Type {
    TEXT,
    GRAPHVIZ
  }

  private final Type type;

  public ExplainFormat(final Type type) {
    this(Optional.empty(), type);
  }

  public ExplainFormat(final NodeLocation location, final Type type) {
    this(Optional.of(location), type);
  }

  private ExplainFormat(final Optional<NodeLocation> location, final Type type) {
    super(location);
    this.type = requireNonNull(type, "type is null");
  }

  public Type getType() {
    return type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(type);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if ((obj == null) || (getClass() != obj.getClass())) {
      return false;
    }
    final ExplainFormat o = (ExplainFormat) obj;
    return Objects.equals(type, o.type);
  }

  @Override
  public String toString() {
    return toStringHelper(this)
        .add("type", type)
        .toString();
  }
}
