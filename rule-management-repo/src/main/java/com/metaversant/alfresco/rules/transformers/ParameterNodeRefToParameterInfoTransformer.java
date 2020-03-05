package com.metaversant.alfresco.rules.transformers;

import com.metaversant.alfresco.rules.model.ParameterInfo;
import org.alfresco.repo.action.ActionModel;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.cmr.repository.NodeService;

import java.io.Serializable;

/**
 * Created by jpotts, Metaversant on 2/27/20.
 */
public class ParameterNodeRefToParameterInfoTransformer {
    public static ParameterInfo transform(NodeService nodeService, NodeRef nodeRef) {
        ParameterInfo parameterInfo = new ParameterInfo();
        parameterInfo.setNodeRef(nodeRef.toString());
        parameterInfo.setName((String) nodeService.getProperty(nodeRef, ActionModel.PROP_PARAMETER_NAME));
        Serializable value = nodeService.getProperty(nodeRef, ActionModel.PROP_PARAMETER_VALUE);
        parameterInfo.setValue(value.toString());
        return parameterInfo;
    }
}
