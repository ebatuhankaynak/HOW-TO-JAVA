package com.mocha.server.listeners;

import com.mocha.server.CompilerCapsule.CompilerCapsule;
import com.mocha.server.Core;
import com.mocha.server.JsonListenerCapsule.JsonListener;
import com.mocha.server.JsonListenerCapsule.RequestTypes;
import com.mocha.server.models.requests.CompileRequest;
import com.mocha.server.models.requests.RegisterRequest;
import com.mocha.server.models.requests.RegisterResultRequest;
import com.mocha.server.models.results.CompilerResult;
import com.mocha.server.models.results.RegisterResults;

public class CompileListener extends JsonListener <CompileRequest> {


    @Override
    public void run(CompileRequest req)
        {
            CompilerResult result;
            CompilerCapsule compiler = new CompilerCapsule();

            compiler.compile(req.getCodeToCompile());





        }
}
