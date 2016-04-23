package com.mocha.client.models.requests;

import com.mocha.client.models.User;
import com.mocha.client.models.results.CompileResult;

/**
 * Created by Hüseyin on 4/23/2016.
 */
public class CompileResultRequest {


        private CompileResult result;
        private User user;
        private boolean [] compilerResults;
        public CompileResultRequest(CompileResult result, boolean[] compilerResults  ) {
            this.result = result;
            this.compilerResults = compilerResults;
        }

        public CompileResult getResult() {
            return result;
        }

        public void setResult(CompileResult result) {
            this.result = result;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }


}
