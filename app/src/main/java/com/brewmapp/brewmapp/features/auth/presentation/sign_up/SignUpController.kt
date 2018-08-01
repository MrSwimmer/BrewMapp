package com.brewmapp.brewmapp.features.main.profile

import android.app.DatePickerDialog
import android.content.Intent
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.auth.presentation.city.CityActivity
import com.brewmapp.brewmapp.features.main.MainActivity
import com.hannesdorfmann.mosby3.mvp.conductor.MvpController
import kotlinx.android.synthetic.main.controller_sign_up.view.*


class SignUpController : BaseController<SignUpContract.View, SignUpContract.Presenter>(), SignUpContract.View{
    companion object {
        var cityId = "no"
        var cityName = "no"
    }

    override fun gotoMain() {
        val intent = Intent(activity, MainActivity::class.java)
        startActivity(intent)
        activity!!.finish()
    }

    var isDatePick = false
    lateinit var dateString: String

    var day = 1
    var month = 1
    var year = 1990

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_sign_up, container, false)
        view.chooseDate.setOnClickListener({onDateClick()})
        view.registration.setOnClickListener({onRegClick()})
        view.cityButton.setOnClickListener({
            startActivity(Intent(activity, CityActivity::class.java))
        })
        return view
    }

    override fun createPresenter(): SignUpContract.Presenter {
        return SignUpPresenter()
    }

    fun onRegClick() {
        if (isFeelingFields()) {
            showProgress()
            presenter.signUp(view!!.email.text.toString(), view!!.password.text.toString(), view!!.first.text.toString(), view!!.last.text.toString(), dateString)
        } else {
            Snackbar.make(view!!, "Заполните все поля и выберите город", Snackbar.LENGTH_SHORT).show()
        }
    }

    fun isFeelingFields(): Boolean {
        return view!!.email.text.toString() != "" && view!!.password.text.toString() != "" && view!!.first.text.toString() != "" && view!!.last.text.toString() != "" && isDatePick && cityId != "no"
    }

    var date: DatePickerDialog.OnDateSetListener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
        day = dayOfMonth
        month = monthOfYear
        this.year = year
        dateString = "$year-$month-$day"
        view!!.chooseDate.text = dateString
    }

    fun onDateClick() {
        //DatePickerDialog(activity, dateCallback, 2018, 1, 1)
        isDatePick = true
        DatePickerDialog(activity, date, year, month, day).show()
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        if(cityId != "no")
            view.cityButton.text = cityName
    }
}