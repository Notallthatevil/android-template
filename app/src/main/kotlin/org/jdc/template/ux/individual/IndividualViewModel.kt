package org.jdc.template.ux.individual

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.analytics.HitBuilders
import com.vikingsen.inject.viewmodel.ViewModelInject
import kotlinx.coroutines.launch
import org.jdc.template.Analytics
import org.jdc.template.livedata.AbsentLiveData
import org.jdc.template.livedata.SingleLiveEvent
import org.jdc.template.model.db.main.individual.Individual
import org.jdc.template.model.repository.IndividualRepository
import org.jdc.template.ui.viewmodel.BaseViewModel

class IndividualViewModel
@ViewModelInject constructor(
        private val analytics: Analytics,
        private val individualRepository: IndividualRepository
) : BaseViewModel() {

    private val individualId = MutableLiveData<Long>()
    val individual: LiveData<Individual>
    val onEditIndividualEvent = SingleLiveEvent<Long>() // individualId
    val onIndividualDeletedEvent = SingleLiveEvent<Void>()

    init {
        individual = AbsentLiveData.switchMap(individualId) {
            loadIndividual(it)
        }
    }

    fun setIndividualId(individualId: Long) {
        if (individualId != this.individualId.value) {
            this.individualId.value = individualId
        }
    }

    private fun loadIndividual(individualId: Long): LiveData<Individual> {
        analytics.send(HitBuilders.EventBuilder().setCategory(Analytics.CATEGORY_INDIVIDUAL).setAction(Analytics.ACTION_VIEW).build())
        return individualRepository.getIndividualLiveData(individualId)
    }

    fun deleteTask() {
        individualId.value?.let { id ->
            launch {
                analytics.send(HitBuilders.EventBuilder().setCategory(Analytics.CATEGORY_INDIVIDUAL).setAction(Analytics.ACTION_DELETE).build())
                individualRepository.deleteIndividual(id)

                onIndividualDeletedEvent.postCall()
            }
        }
    }

    fun editTask() {
        onEditIndividualEvent.value = individualId.value
    }
}