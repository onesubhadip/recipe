package com.recipe.lib.cqs;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class CommandResult {

    private UUID commandId;
    private String commandName;
    private CommandStatus status;
    private String message;
    private String errorCode;

}
