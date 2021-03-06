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

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Statements extends Node {

  public List<Statement> statementList;

  public Statements(final List<Statement> statementList) {
    super(Optional.empty());
    this.statementList = statementList;
  }

  protected Statements(final Optional<NodeLocation> location, final List<Statement> statementList) {
    super(location);
  }

  @Override
  public <R, C> R accept(final AstVisitor<R, C> visitor, final C context) {

    return visitor.visitStatements(this, context);
  }

  @Override
  public String toString() {
    return toStringHelper(this)
        .toString();
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if ((obj == null) || (getClass() != obj.getClass())) {
      return false;
    }
    final Statements o = (Statements) obj;
    return Objects.equals(statementList, o.statementList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statementList);
  }
}
