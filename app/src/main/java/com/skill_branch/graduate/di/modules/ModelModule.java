package com.skill_branch.graduate.di.modules;

import com.birbit.android.jobqueue.JobManager;
import com.birbit.android.jobqueue.config.Configuration;

import com.skill_branch.graduate.data.managers.DataManager;
import com.skill_branch.graduate.utils.App;
import com.skill_branch.graduate.utils.AppConfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ModelModule{
    @Provides
    @Singleton
    DataManager provideDataManager(){
        return DataManager.getInstance();
    }


    @Provides
    JobManager provideJobManager(){
        Configuration config = new Configuration.Builder(App.getContext())
                .minConsumerCount(AppConfig.MIN_CONSUMER_COUNT) //minimum 1 consumer alive
                .maxConsumerCount(AppConfig.MAX_CONSUMER_COUNT) //maximum 3 consumers
                .loadFactor(AppConfig.LOAD_FACTOR) // maximum 3 jobs per consumer
                .consumerKeepAlive(AppConfig.KEEP_ALIVE) //wait 2 minutes
                .build();

        return new JobManager(config);
    }
}
