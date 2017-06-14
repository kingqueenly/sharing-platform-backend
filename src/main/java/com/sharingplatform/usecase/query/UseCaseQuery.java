package com.benz.usecase.query;

import com.benz.framework.domain.QueryParameter;
import com.benz.framework.query.BaseQuery;
import com.benz.framework.query.PageParameter;
import com.benz.framework.query.PagedList;
import com.benz.usecase.domain.CategoryList;
import com.benz.usecase.domain.PhaseList;
import com.benz.usecase.domain.StageList;
import com.benz.usecase.domain.UseCase;
import com.benz.usecase.domain.event.UseCaseViewedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by hongying.fu on 12/15/2016.
 */
@Service
public class UseCaseQuery extends BaseQuery {

    @Autowired
    private UseCaseMapper useCaseMapper;

    @Autowired
    private ApplicationEventPublisher publisher;

    public PagedList<UseCaseResult> findAll(final UseCaseParameter parameter, Integer pageNum) {

        PagedList<UseCaseResult> useCaseResultPagedList = paging(parameter, new Callable<List<UseCaseResult>>() {
            public List<UseCaseResult> call() {
                if(parameter!=null){
                    String subject = parameter.getSubject();
                    if (subject != null && !"".equals(subject))
                        parameter.setSubject(subject.toUpperCase());
                }
                return useCaseMapper.findAll(parameter);
            }
        }, new PageParameter(pageNum));

        return useCaseResultPagedList;
    }

    public UseCaseResult findById(QueryParameter queryParameter, Long id) {

        this.publisher.publishEvent(new UseCaseViewedEvent(queryParameter.getOperatorId(), id));
        UseCaseResult result = useCaseMapper.findById(id);
        System.out.println("use case result:"+result);
        return result;
    }

    public PagedList<UseCaseResult> findAllByUserId(final UseCaseParameter parameter, Integer pageNum) {

        PagedList<UseCaseResult> useCaseResultPagedList = paging(parameter, new Callable<List<UseCaseResult>>() {
            public List<UseCaseResult> call() {
                return useCaseMapper.findByUserId(parameter);
            }
        }, new PageParameter(pageNum));

        return useCaseResultPagedList;
    }

    public PagedList<UseCaseResult> findAllByLikeUserId(final UseCaseParameter parameter, Integer pageNum) {

        PagedList<UseCaseResult> useCaseResultPagedList = paging(parameter, new Callable<List<UseCaseResult>>() {
            public List<UseCaseResult> call() {
                return useCaseMapper.findByLikeUserId(parameter);
            }
        }, new PageParameter(pageNum));

        return useCaseResultPagedList;
    }

    public PagedList<UseCaseResult> findByContributionBU(final UseCaseParameter parameter, Integer pageNum) {

        PagedList<UseCaseResult> useCaseResultPagedList = paging(parameter, new Callable<List<UseCaseResult>>() {
            public List<UseCaseResult> call() {
                return useCaseMapper.findByContributionBU(parameter);
            }
        }, new PageParameter(pageNum));

        return useCaseResultPagedList;
    }

    public List<CategoryList> findByCategory(CategoryListParameter categoryListParameter) {
        final UseCaseParameter parameter = new UseCaseParameter();
        String[] stages = new String[]{"Concept", "Analysis", "Validation", "Implementation"};
        List<CategoryList> categoryLists = new ArrayList<CategoryList>();
        List<CategoryParameter> categoryParameters = categoryListParameter.getCategoryParameterList();
        for(CategoryParameter cp : categoryParameters){
            CategoryList categoryList = new CategoryList();
            categoryList.setCategory(cp.getCategory());

            List<StageList> stageLists = new ArrayList<StageList>();
            categoryList.setList(stageLists);

            List<UseCaseResult> categoryCases = new ArrayList<UseCaseResult>();

            List<String> phases = cp.getPhases();
            for (String phase : phases) {
                System.out.println("phase:" + phase);
                parameter.setPhase(phase.toUpperCase());
                List<UseCaseResult> useCases = useCaseMapper.findByPhaseStage(parameter);
                categoryCases.addAll(useCases);
            }

            for (String stage : stages) {
                StageList stageList = new StageList();
                stageList.setStage(stage);
                List<UseCaseResult> list = new ArrayList<>();
                for (UseCaseResult result : categoryCases) {
                    if (stage.equalsIgnoreCase(result.getStage())) {
                        list.add(result);
                    }
                }
                stageList.setList(list);
                stageLists.add(stageList);
            }
            categoryLists.add(categoryList);
        }

        return categoryLists;
    }

    public List<PhaseList> findByPhases(List<String> phases) {
        final UseCaseParameter parameter = new UseCaseParameter();
        String[] stages = new String[]{"Concept", "Analysis", "Validation", "Implementation"};
        List<PhaseList> phaseLists = new ArrayList<>();
        for (String phase : phases) {
            System.out.println("phase:" + phase);
            PhaseList phaseList = new PhaseList();
            phaseList.setPhase(phase);
            List<StageList> stageLists = new ArrayList<>();
            phaseList.setList(stageLists);

            parameter.setPhase(phase.toUpperCase());
            List<UseCaseResult> useCases = useCaseMapper.findByPhaseStage(parameter);

            for (String stage : stages) {
                StageList stageList = new StageList();
                stageList.setStage(stage);
                List<UseCaseResult> list = new ArrayList<>();
                for (UseCaseResult result : useCases) {
                    if (stage.equalsIgnoreCase(result.getStage())) {
                        list.add(result);
                    }
                }
                stageList.setList(list);
                stageLists.add(stageList);
            }
            phaseLists.add(phaseList);
        }
        return phaseLists;
    }

    public PagedList<UseCaseResult> findByPhaseStage(final UseCaseParameter parameter, Integer pageNum) {
        PagedList<UseCaseResult> useCaseResultPagedList = paging(parameter, new Callable<List<UseCaseResult>>() {
            public List<UseCaseResult> call() {
                String phase = parameter.getPhase();
                String stage = parameter.getStage();
                if(phase!= null && !"".equals(phase))
                    parameter.setPhase(phase.toUpperCase());
                if(stage!=null && !"".equals(stage))
                    parameter.setStage(stage.toUpperCase());
                return useCaseMapper.findByPhaseStage(parameter);
            }
        }, new PageParameter(pageNum));

        return useCaseResultPagedList;
    }
}