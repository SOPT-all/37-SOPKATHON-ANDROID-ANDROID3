package org.sopt.soptackthon_app_3.presentation.juwan.viewmodel

data class ServiceItem(
    val id: Long,
    val name: String,
    val hourlyRate: Double
)

object ServiceData {
    val services = listOf(
        ServiceItem(id = 1, name = "House Keeping", hourlyRate = 15.0),
        ServiceItem(id = 2, name = "Grocery Shopping", hourlyRate = 12.0),
        ServiceItem(id = 3, name = "Transportation Assistance", hourlyRate = 18.0),
        ServiceItem(id = 4, name = "Social Support", hourlyRate = 20.0)
    )

    fun getServiceById(id: Long): ServiceItem? {
        return services.find { it.id == id }
    }
}