package kr.co.domain.api.usecase

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kr.co.data.response.ImagePidNumberResponse
import kr.co.domain.api.service.FileService
import kr.co.domain.koin.repository.remote.RetrofitRepository

class PostImproveImagePidNumber(retrofitRepository: RetrofitRepository){
    private val fileService = retrofitRepository
        .getRetrofit()
        .create(FileService::class.java)

    fun postImproveImagePidNumber(reqEditType: String, imageFileObjectPid: String, title: String): Single<ImagePidNumberResponse> = fileService
        .postImproveImagePidNumber(reqEditType, imageFileObjectPid, title)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}