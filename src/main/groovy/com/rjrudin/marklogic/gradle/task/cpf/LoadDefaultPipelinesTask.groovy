package com.rjrudin.marklogic.gradle.task.cpf

import org.gradle.api.tasks.TaskAction

import com.rjrudin.marklogic.gradle.task.MarkLogicTask
import com.rjrudin.marklogic.mgmt.cpf.PipelineManager

class LoadDefaultPipelinesTask extends MarkLogicTask {

    String databaseName

    @TaskAction
    void loadDefaultPipelines() {
        def dbName = databaseName != null ? databaseName : getAppConfig().getTriggersDatabaseName()
        new PipelineManager(getManageClient()).loadDefaultPipelines(dbName)
    }
}