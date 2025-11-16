import axios from 'axios'
import { API_GATEWAY_BASE_URL } from './config'
import { data } from 'react-router'
import qs from 'qs'

class ApiDinamica {
    constructor() {
        this.tokenAuth = null
        this.axiosInstance = axios.create({
            baseURL: `${API_GATEWAY_BASE_URL}/api/dinamica`,
        })
    }

    async crearHecho(hechoData) {
        try {
            const response = await this.axiosInstance.post('/hechos', hechoData)
            return response.data
        } catch (error) {
            console.error('Error al crear el hecho:', error)
            throw error
        }
    }

    async cargarImagen (hechoId, archivoImagen) {
        try {
            const formData = new FormData()
            formData.append('file', archivoImagen)

            const response = await this.axiosInstance.post(
                `/upload/${hechoId}`,
                formData,
                {
                    headers: {
                        'Content-Type': 'multipart/form-data',
                    },
                }
            )
            return response.data
        } catch (error) {
            console.error('Error al cargar la imagen:', error)
            throw error
        }
    }
}

const apiDinamica = new ApiDinamica()
export default apiDinamica