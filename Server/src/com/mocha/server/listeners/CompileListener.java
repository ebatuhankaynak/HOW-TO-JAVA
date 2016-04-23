package com.mocha.server.listeners;

import com.mocha.server.CompilerCapsule.CompilerCapsule;
import com.mocha.server.JsonListenerCapsule.JsonListener;
import com.mocha.server.models.requests.CompileRequest;
import com.mocha.server.models.results.CompileResult;

public class CompileListener extends JsonListener <CompileRequest> {


    @Override
    public void run(CompileRequest req)
        {
            CompileResult result;
            CompilerCapsule compiler = new CompilerCapsule();
            // TODO: 4/23/2016 boolean []   =  
            compiler.compile(req.getCodeToCompile());

            if (compiler.isCompiled())
            {
                result = CompileResult.SUCCESS;
            }
            else
            {
                result = CompileResult.FAILURE;
            }
            //Core.ServerManager.sendMessageObject(getClientUID(), RequestTypes.COMPILE_RESULT, new CompileResultRequest(result));
            System.out.println("sent " + result);
        }
}

