package com.mocha.server.listeners;

import com.mocha.server.CompilerCapsule.CompilerCapsule;
import com.mocha.server.Core;
import com.mocha.server.JsonListenerCapsule.JsonListener;
import com.mocha.server.JsonListenerCapsule.RequestTypes;
import com.mocha.server.models.requests.CompileRequest;
import com.mocha.server.models.requests.CompileResultRequest;
import com.mocha.server.models.results.CompileResult;

public class CompileListener extends JsonListener <CompileRequest> {


    @Override
    public void run(CompileRequest req)
        {
            CompileResult result;
            CompilerCapsule compiler = new CompilerCapsule();
            // TODO: 4/23/2016 give the correcct boolean array when check is implemented
            //boolean[] isPassed = {true,true,true,true};
           // System.out.println(req.getQuestion().getTestClass());
            String [] compilerResults = compiler.compile(req.getCodeToCompile(), req.getQuestion());
            boolean[] isPassed =  req.getQuestion().check(compilerResults);
            if (compiler.isCompiled())
            {
                result = CompileResult.SUCCESS;
            }
            else
            {
                result = CompileResult.FAİL;
                for( int i = 0; i < isPassed.length; i++) {
                    isPassed[i] = false;
                }
            }
            Core.ServerManager.sendMessageObject(getClientUID(), RequestTypes.COMPILE_RESULT, new CompileResultRequest
                    (result, isPassed,compilerResults));
            System.out.println("sent " + result);
        }
}

