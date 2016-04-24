package com.mocha.client.models.requests;

import com.mocha.client.models.User;
import com.mocha.client.models.results.CompileResults;

/**
 * Created by Hüseyin on 4/23/2016.
 */
public class CompileResultRequest {


        private CompileResults result;
        private User user;
        private boolean [] compilerResults;
        public CompileResultRequest(CompileResults result, boolean[] compilerResults  ) {
            this.result = result;
            this.compilerResults = compilerResults;
        }

        public CompileResults getResult() {
            return result;
        }

        public void setResult(CompileResults result) {
            this.result = result;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }


}
