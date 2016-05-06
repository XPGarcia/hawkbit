/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.hawkbit.mgmt.client.resource.builder;

import org.eclipse.hawkbit.rest.resource.model.rollout.RolloutCondition;
import org.eclipse.hawkbit.rest.resource.model.rollout.RolloutCondition.Condition;
import org.eclipse.hawkbit.rest.resource.model.rollout.RolloutRestRequestBody;

/**
 * 
 * Builder pattern for building {@link RolloutRestRequestBody}.
 *
 */
// Exception squid:S1701 - builder pattern
@SuppressWarnings({ "squid:S1701" })
public class RolloutBuilder {

    private String name;
    private int groupSize;
    private String targetFilterQuery;
    private long distributionSetId;
    private String successThreshold;
    private String errorThreshold;

    /**
     * @param name
     *            the name of the rollout
     * @return the builder itself
     */
    public RolloutBuilder name(final String name) {
        this.name = name;
        return this;
    }

    /**
     * @param groupSize
     *            the amount of groups the rollout should be split into
     * @return the builder itself
     */
    public RolloutBuilder groupSize(final int groupSize) {
        this.groupSize = groupSize;
        return this;
    }

    /**
     * @param targetFilterQuery
     *            the FIQL query language to filter targets to contain in the
     *            rollout
     * @return the builder itself
     */
    public RolloutBuilder targetFilterQuery(final String targetFilterQuery) {
        this.targetFilterQuery = targetFilterQuery;
        return this;
    }

    /**
     * @param distributionSetId
     *            the ID of the distribution set to assign to the target in the
     *            rollout
     * @return the builder itself
     */
    public RolloutBuilder distributionSetId(final long distributionSetId) {
        this.distributionSetId = distributionSetId;
        return this;
    }

    /**
     * @param successThreshold
     *            the threshold to be used to indicate if a deployment group is
     *            successful, to trigger the success action
     * @return the builder itself
     */
    public RolloutBuilder successThreshold(final String successThreshold) {
        this.successThreshold = successThreshold;
        return this;
    }

    /**
     * @param errorThreshold
     *            the threshold to be used to indicate if a deployment group is
     *            failing, to trigger the error action
     * @return the builder itself
     */
    public RolloutBuilder errorThreshold(final String errorThreshold) {
        this.errorThreshold = errorThreshold;
        return this;
    }

    /**
     * Builds the rollout rest body to creating a rollout.
     * 
     * @return the rest request body for creating a rollout
     */
    public RolloutRestRequestBody build() {
        return doBuild();
    }

    private RolloutRestRequestBody doBuild() {
        final RolloutRestRequestBody body = new RolloutRestRequestBody();
        body.setName(name);
        body.setAmountGroups(groupSize);
        body.setTargetFilterQuery(targetFilterQuery);
        body.setDistributionSetId(distributionSetId);
        body.setSuccessCondition(new RolloutCondition(Condition.THRESHOLD, successThreshold));
        body.setErrorCondition(new RolloutCondition(Condition.THRESHOLD, errorThreshold));
        return body;
    }

}
